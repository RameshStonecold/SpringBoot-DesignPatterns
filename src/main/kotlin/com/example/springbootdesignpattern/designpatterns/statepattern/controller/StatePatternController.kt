package com.example.springbootdesignpattern.designpatterns.statepattern.controller

import com.example.springbootdesignpattern.designpatterns.statepattern.config.ResponseWithError
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.PaidReasonDto
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.RejectedReasonDto
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.StudentInvoiceDto
import com.example.springbootdesignpattern.designpatterns.statepattern.service.IStatePatternService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/studentInvoice")
@Api(value = "StatePatternController", description= "Rest API for center batch Management")

class StatePatternController {

    @Autowired
    internal var service:IStatePatternService?=null


    @GetMapping("/{id}")
    @CrossOrigin
    @ApiOperation(value = " getStudentInvoiceId", notes = "URI to get StudentInvoice By Id.", produces = "application/json", consumes = "application/json", response = StudentInvoiceDto::class)
    fun getAttendanceById(@PathVariable("id") id: String): ResponseEntity<*> {
        try {
            val result = service!!.getById(id)
            if(result.isLeft){
                return ResponseEntity(ResponseWithError.ofError<String>(result.left.message), HttpStatus.BAD_REQUEST)
            }
            return ResponseEntity(ResponseWithError.of(result.get()), HttpStatus.ACCEPTED)

        } catch (e: Exception) {
            return ResponseEntity(ResponseWithError.ofError<String>("false"),
                    HttpStatus.BAD_REQUEST)
        }
    }




    @PostMapping("/generateInvoice")
    @CrossOrigin
    @ApiOperation(value = "Generate Student Invoice ", notes = "URI To Generate Student Invoice Report", produces = "application/json", consumes = "application/json")
    fun generateStudentInvoice( @RequestBody studentInvoiceDto: StudentInvoiceDto): ResponseEntity<*> {

        val invoiceEither = service!!.generateInvoice(studentInvoiceDto)


        return when (invoiceEither.isLeft)
        {
            true -> {

                ResponseEntity(ResponseWithError.ofError<String>(invoiceEither.left.message), HttpStatus.BAD_REQUEST)
            }
            false -> ResponseEntity(ResponseWithError.of<String>(invoiceEither.get()), HttpStatus.CREATED)
        }
    }



    @PutMapping("/changeStatusToPaid")
    @CrossOrigin
    @ApiOperation(value = "Change Status To PAID", notes = "URI To Change Status To PAID", produces = "application/json", consumes = "application/json")
    fun changeStatusToPaid(@RequestBody paidReasonDto: PaidReasonDto): ResponseEntity<*> {

        val result = service!!.changeStatusToPaid(paidReasonDto)
        return when (result.isLeft) {
            true -> {

                ResponseEntity(ResponseWithError.ofError<String>(result.left.message), HttpStatus.BAD_REQUEST)
            }

            false -> ResponseEntity(ResponseWithError.of(result.get()), HttpStatus.ACCEPTED)
        }
    }

    @PutMapping("/changeStatusRejected")
    @CrossOrigin
    @ApiOperation(value = "Change Status To Rejected", notes = "URI To Change Status To Rejected", produces = "application/json", consumes = "application/json")
    fun changeStatusToRejected(@Valid @RequestBody rejectedReasonDto: RejectedReasonDto): ResponseEntity<*> {

        val result = service!!.changeStatusToRejected(rejectedReasonDto)
        return when (result.isLeft) {
            true -> {

                ResponseEntity(ResponseWithError.ofError<String>(result.left.message), HttpStatus.BAD_REQUEST)
            }

            false -> ResponseEntity(ResponseWithError.of(result.get()), HttpStatus.ACCEPTED)
        }
    }




}
