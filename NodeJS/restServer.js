const express = require('express');
const fs = require('fs');
const mysql = require('mysql');

const PORT = process.env.PORT || 3000;

var conn = mysql.createConnection({
    host: "203.189.123.200",
    user: "nodejs",
    password : "1SCCHo0WDNBrrned",
    database : "nodejs",
});

conn.connect(err=>{
    if (err) throw err;
    console.log("connected to mysql server");
});

const app = express();
app.use(express.json());

app.get("/test",(req,res)=>{
    res.send("Testing GET method");
});

app.post("/test",(req,res)=>{
    res.send("Testing POST method");
});

app.put("/test",(req,res)=>{
    res.send("Testing PUT method");
});

app.delete("/test",(req,res)=>{
    res.send("Testing DELETE method");
});

app.get("/users",(req,res)=>{
    var sql = "SELECT * FROM user";
    conn.query(sql, (err,result)=>{
        if (err) throw err;
        // console.log(result);
        res.json(result);
    });

    // fs.readFile(__dirname + "/" + "users.json",'utf8', (err,data)=>{
    //     res.end(data);
    // });
});

app.get("/users/:id",(req,res)=>{
    var sql = "SELECT * FROM user WHERE id="+req.params.id;
    conn.query(sql, (err,result)=>{
        if (err) throw err;
        // console.log(result);
        res.json(result[0]);
    });

//     fs.readFile(__dirname + "/" + "users.json",'utf8', (err,data)=>{
//         var users = JSON.parse(data);
// //        console.log(users);
//         var user = users.users.find(u=> u.id == req.params.id);
//         if (typeof user === 'undefined') {
//             res.status(404).send({
//                 error: "Not found"
//             });
//         } else {
//             res.status(200).send(user)
//         }
//     });
});

app.post("/users",function(req,res){
    var data = {username: req.body.nama, pass: req.body.pass};
    var sql = "INSERT into user SET ?";
    var query = conn.query(sql, data, (err,result)=>{
        if (err) throw err;
        res.json(result);
    });
});

app.put("/changepasswd/:id",(req,res)=>{
    var sql = "UPDATE user SET pass='"+req.body.pass+
            "' WHERE id="+req.params.id;
    var query = conn.query(sql, (err,result)=>{
        if (err) throw err;
        res.json(result);
    });
});

app.delete("/users/:id",(req,res)=>{});


app.get("/dummy/:id",(req,res)=>{});
// app.get("/dummy/:id",function(req,res){});


app.listen(PORT, () => {
    console.log("Server Listening on PORT:", PORT);
});