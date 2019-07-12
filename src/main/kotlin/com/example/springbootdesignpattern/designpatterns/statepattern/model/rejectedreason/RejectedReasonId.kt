package com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason

import java.util.*

class RejectedReasonId {
    private var id= UUID.randomUUID().toString()

    constructor(id: String) {
        this.id = id
    }

    fun getId():String?{
        return this.id
    }
    constructor()
}
