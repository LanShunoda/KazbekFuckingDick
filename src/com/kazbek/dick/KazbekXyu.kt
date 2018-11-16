package com.kazbek.dick

import java.io.File

fun main(args: Array<String>) {

    fileNamesGenerator().take(100)
        .forEachIndexed { index, s: String ->
            val folder = File(index.toString() + s)
            folder.mkdir()
            fileNamesGenerator().take(100)
                .forEachIndexed { i, name ->
                    val file = File(folder, i.toString() + name + ".txt")
                    kazbekXyuTextGenerator().take(20)
                        .forEach {
                            file.writeText(it)
                        }

                }
        }
}

private fun kazbekXyuTextGenerator(): Sequence<String> {
    return generateSequence("Казбек - хуй, бо не запросив Фіму! ") { it + it + "Сука, йобана рубашка! " }
}

private fun fileNamesGenerator(): Sequence<String> {
    return generateSequence(listOf("Казбек-хуй", "Незапросив_Фіму", "Йобана_рубашка")) { it }.flatten()
}