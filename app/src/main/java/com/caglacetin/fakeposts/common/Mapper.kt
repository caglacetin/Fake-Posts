package com.caglacetin.fakeposts.common

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}