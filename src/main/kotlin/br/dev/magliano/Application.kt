package br.dev.magliano

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.dev.magliano")
		.start()
}

