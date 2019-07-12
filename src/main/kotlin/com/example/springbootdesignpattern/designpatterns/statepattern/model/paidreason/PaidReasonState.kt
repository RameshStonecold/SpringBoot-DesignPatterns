package com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document
class PaidReasonState:IPaidReason {

    @Id
    private var id:String=UUID.randomUUID().toString()

    private var invoiceId:String?=null

    private var paidReason:String?=null

    private var reasonCreatedDate:LocalDate?=null

    private var reasonUpdateDate:LocalDate?=null

    fun setId(id:String){
        this.id=id
    }
    fun getId():PaidReasonId{
        return PaidReasonId(this.id)
    }

    override fun getPaidReasonId(): PaidReasonId {
       return this.getId()
    }

    override fun getInvoiceId(): String? {
       return this.invoiceId
    }

    fun setInvoiceId(invoiceId:String?){
        this.invoiceId=invoiceId
    }

    override fun getPaidReason(): String? {
       return this.paidReason
    }

    fun setPaidReason(paidReason:String?){
        this.paidReason=paidReason
    }

    fun setReasonCreatedDate(reasonCreatedDate:LocalDate?){
        this.reasonCreatedDate=reasonCreatedDate
    }
    override fun getReasonCreatedDate(): LocalDate? {
      return this.reasonCreatedDate
    }

    fun setReasonUpdatedDate(reasonUpdatedDate:LocalDate?){
        this.reasonUpdateDate=reasonUpdateDate
    }
    override fun getReasonUpdateDate(): LocalDate? {
     return this.reasonUpdateDate
    }




}
