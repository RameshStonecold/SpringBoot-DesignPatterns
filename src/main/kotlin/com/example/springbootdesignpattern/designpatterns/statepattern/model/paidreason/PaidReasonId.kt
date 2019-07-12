package com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
class PaidReasonId :Serializable{

    private var id= UUID.randomUUID().toString()

    constructor(id: String) {
        this.id = id
    }

    fun getId():String?{
        return this.id
    }
    constructor()


}
