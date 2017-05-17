//Load Express Framework
var express = require('express');

//Load Mustache Template Engine
var mustachex = require('mustachex');

//Load Oracle
var oracledb = require('oracledb');

//Call express
var app = express();

var bodyParser = require('body-parser');

var orawrap = require('orawrap');
var dbConfig = {
    user: 'txg160430',
    password: 'chinnu1994',
    connectString: 'csoracle.utdallas.edu/student.csoracle.utdallas.edu',
    poolMax: 20,
    poolMin: 2,
    poolIncrement: 2,
    poolTimeout: 10
};

//Set Global App Settings
app.engine('html', mustachex.express);
app.use(express.static(__dirname + '/public'));
app.set('view engine', 'html');
app.set('views', __dirname + '/htm');

app.use(bodyParser.json()); // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/domain', function(req, res) {
  res.render('domain.html');
});
app.get('/tld_domain', function(req, res) {
  res.render('tld_domain.html');
});
app.get('/domain/idx1', function(req, res) {
  res.render('domain_idx1.html');
});
app.get('/tld_domain/idx1', function(req, res) {
  res.render('tld_domain_idx1.html');
});
app.get('/domain/idx2', function(req, res) {
  res.render('domain_idx2.html');
});
app.get('/tld_domain/idx2', function(req, res) {
  res.render('tld_domain_idx2.html');
});
app.get('/domain/idx3', function(req, res) {
  res.render('domain_idx3.html');
});
app.get('/tld_domain/idx3', function(req, res) {
  res.render('tld_domain_idx3.html');
});
app.post('/search', function(req, res) {
 var domain = req.body.domain;
 //var tld= req.body.tld;
 var table_name = req.body.table_name;
 var sql_statement =  "SELECT GlobalRank FROM "+ table_name+" M WHERE M.Domain= '"+domain+"'";

 orawrap.execute(
         sql_statement,
         function(err, rank)
         {
           if (err) {
              console.error(err);
              res.render('domainerror',
                {
                  message: err.message
                }
              );

           }
           else {
             if (rank.rows.length >0) {
               res.render('rank',
               {
                 GlobalRank: rank.rows[0],
               }
               );
             }
             else {
               res.render('domainerror',
               {
                  message: "No domain with such name"

               }
               );
             }
           }
        }
 );
});

app.post('/search2', function(req, res) {
  var tld= req.body.tld;
  var table_name = req.body.table_name;
  var max= req.body.max;                                                                            
 var sql_statement =  "SELECT GlobalRank,Domain FROM "+table_name+" M WHERE M.TLD= '"+tld+"'";

 orawrap.execute(
         sql_statement,[],{ maxRows: parseInt(max) },
         function(err, tldresult)
         {
           if (err) {
              console.error(err);
              res.render('tlderror',
                {
                  message: err.message
                }
              );

           }
           else {
             var i;
             var data="";
             for(i=0;i<tldresult.rows.length;i++){
              data+="<ul><li>"+"GlobalRank: "+tldresult.rows[i][0]+"</li>"+"<li>"+"Domain: "+tldresult.rows[i][1]+"</li></ul>"
             }
             //data+="</ul>"
             //console.log(data);
             if (tldresult.rows.length >0) {
               res.render('tld',
               {
                 list:data,
               }
               );
             }
             else {
               res.render('tlderror',
               {
                  message: "No TLD with such name"

               }
               );
             }
           }
        }
 );
});

//Create Server
var port = Number(process.env.PORT || 5252);
orawrap.createPool(dbConfig, function(err, pool) {
   // The pool that was created is provided in the callback function,  
   // but it's rarely needed as it's stored within orawrap for use later 
   if (err) throw err;
   //Start the web server now that the pool is ready to handle incoming requests 
   app.listen(port, "csgrads1.utdallas.edu", function() {
       console.log('Web server listening on localhost: ' + port);
   });
});