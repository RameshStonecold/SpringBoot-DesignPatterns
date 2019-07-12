package com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document
class RejectedReasonState :IRejectedReason{

    @Id
    private var id:String=UUID.randomUUID().toString()

    private var invoiceid:String?= null

    private var reason:String?=null

    private var reasonCreatedDate:LocalDate?=null

    private var reasonUpdatedDate:LocalDate?=null

    fun setId(id:String){
        this.id=id
    }
    fun  getId(){
        return
    }



    override fun getRejectedReasonId(): RejectedReasonId {
        return RejectedReasonId(this.id)
    }

    fun setInvoiceId(invoiceId:String?){
        this.invoiceid=invoiceid
    }
    override fun getInvoiceId(): String? {
        return this.invoiceid
    }

    fun setReason(reason:String?){
        this.reason=reason
    }
    override fun getReason(): String? {
        return this.reason
    }


    fun setReasonCreatedDate(reasonCreatedDate:LocalDate?){
        this.reasonCreatedDate=reasonCreatedDate
    }
    override fun getReasonCreatedDate(): LocalDate? {
        return this.reasonCreatedDate
    }

    fun setReasonUpdatedDate(reasonUpdatedDate:LocalDate?){
        this.reasonUpdatedDate=reasonUpdatedDate
    }
    override fun getReasonUpdatedDate(): LocalDate? {
        return this.reasonUpdatedDate
    }




}
