package com.caglacetin.fakeposts.common

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}

interface DoubleMapper<R, SR, D> {
    fun mapFrom(type: R, secondType: SR): D
}