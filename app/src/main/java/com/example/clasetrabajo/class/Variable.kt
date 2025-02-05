//package com.example.clasetrabajo.class

//class Variable {
//}

fun main(){
    //Numeric variables
    val age:Int = 20
    val long_number:Long = 3437823872377777777
    val temperature:Float = 27.44444f
    val weight:Double = 23.44444444

    //String variables

    val gender:Char = 'M'
    val name:String = "Manny Juarez"

    //bool variables

    val isGreater = false
    //otra forma
    val isG:Boolean = true

    //Collection variables

    val names = arrayOf("Manny", "Juan", "Julio", "Pepe")
    println(age)

    println("welcome $name, to your first Kotlin program")
    //invocando las funciones
    //invocar funcion con salto de linea
    println(add())
    //invocar funcion y pasar parametros
    println(product(5, 5))
    printArray(names)
}

fun add():Int{ //indicar tipo de dato de retorno
    //Declaración de variables
    val x = 10
    val y = 5
    //Retornar la suma
    return (x+y)
}

fun product(x:Int, y:Int):Int{ //parametros recibidos de main() tipo Int
    //retornar el producto de los parametros recibidos
    return (x * y)
}

fun printArray(names:Array<String>){
    println(names)
    //ciclo for para recorrer el array
    //Se asigna una variable name a cada elemento
    for(name in names){
        println("Hola $name")
    }
}