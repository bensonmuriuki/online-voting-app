package com.example.benson_project.models


class Nominee{
    var name:String=""
    var email :String=""
    var post:String=""
    var id:String=""
    var votes: Int= 0

    constructor(name:String,email:String,post:String,votes :Int,id:String){
        this.name=name
        this.email=email
        this.post=post
        this.votes=votes
        this.id=id


    }
    constructor()
}
