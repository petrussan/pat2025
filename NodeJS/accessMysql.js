const mysql = require('mysql');

var conn = mysql.createConnection({
    host: "203.189.123.200",
    user: "nodejs",
    password : "1SCCHo0WDNBrrned",
    database : "nodejs",
});

conn.connect(err=>{
    if (err) throw err;
    console.log("connected to mysql server");
    var sql = "SELECT * FROM user";
    conn.query(sql, (err,result)=>{
        if (err) throw err;
        console.log(result);
    });
});

