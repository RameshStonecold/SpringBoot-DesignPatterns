package com.example.springbootdesignpattern.designpatterns.statepattern.model.dto

import com.example.springbootdesignpattern.designpatterns.statepattern.model.invoice.StudentInvoice
import com.example.springbootdesignpattern.designpatterns.statepattern.model.invoice.StudentInvoiceState
import org.springframework.beans.BeanUtils

class InvoiceDtoConverter {
    object Converter{

        fun studentInvoiceDtoToBean(studentInvoiceDto: StudentInvoiceDto): StudentInvoice {

            val studentInvoiceState= StudentInvoiceState()

            BeanUtils.copyProperties(studentInvoiceDto,studentInvoiceState,"invoiceCreatedDate","invoiceUpdateDate")

            return StudentInvoice(studentInvoiceState)
        }



        //Bean to Dto


        fun studentInvoiceBeanToDto(studentInvoice:StudentInvoice):StudentInvoiceDto{

            val studentInvoiceDto=StudentInvoiceDto()

            BeanUtils.copyProperties(studentInvoice.convertToState(),studentInvoiceDto)
            return studentInvoiceDto
        }


    }

}
