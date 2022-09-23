package com.atebsydev.restaurantssocialmobileapp

import android.text.TextUtils.replace
import java.util.*
import kotlin.collections.ArrayList

class Demo {

    fun parseCsv(csv: String, separator: String, quote: String): ArrayList<ArrayList<String>> {

        var lines: ArrayList<ArrayList<String>> = ArrayList<ArrayList<String>>()
        var fieldLastIndex = 0
        var currentLine = ArrayList<String>()
        var isQuotedFieldOpened = false
        var isInnerQuotedOpened = false
        var innerQuoteCount = 0
        val quoteChar = quote[0]
        for ((index, char) in csv.withIndex()) {
            if (char == quoteChar) {
                if (isQuotedFieldOpened) {
                    if (!isInnerQuotedOpened && innerQuoteCount == 0) {
                        isQuotedFieldOpened = false
                    } else {
                        if (innerQuoteCount <= 1) {
                            innerQuoteCount++
                        } else {
                            isInnerQuotedOpened = !isInnerQuotedOpened
                            if (!isInnerQuotedOpened) {
                                //reinitialise the count
                                innerQuoteCount = 0
                            }
                        }
                    }

                }else{
                    isQuotedFieldOpened = true
                }
            } else if (char.equals(separator.single())) {
                currentLine.add(csv.substring(fieldLastIndex, index))
                fieldLastIndex = index + 1
            } else if ((char.equals('\n') && !isQuotedFieldOpened) || index == csv.lastIndex) {
                if (index == csv.lastIndex){
                    var field = csv.substring(fieldLastIndex)
                    currentLine.add(field.replace("\"\"","\""))
                }else{
                    var field = csv.substring(fieldLastIndex, index)
                    currentLine.add(field.replace("\"\"","\""))
                }
                fieldLastIndex = index + 1
                if (!isQuotedFieldOpened) {
                    lines.add(ArrayList(currentLine.toList()))
                    currentLine.clear()
                }
            }
        }

        return lines
    }

    fun possibilities(signals: String): ArrayList<String> {


        return arrayListOf()
    }
}