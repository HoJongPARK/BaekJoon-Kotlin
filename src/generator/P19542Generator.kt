package generator

import java.io.File
import java.io.IOException
import java.io.PrintWriter
import java.lang.StringBuilder
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
    val path = "./in"
    val sb = StringBuilder()
    sb.append(1000, " ", 1, " ", 0).append("\n")
    for (i in 1..999) {
        sb.append(i).append(" ").append(i + 1).append("\n")
    }
    try {
        Files.write(Paths.get(path), sb.toString().toByteArray(), StandardOpenOption.CREATE)
    } catch (e: IOException) {
        e.printStackTrace()
    }

}