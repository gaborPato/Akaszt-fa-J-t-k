package modell

import java.io.File

object PhotoService {

    private val PhotoPath = "./Photos"
    private var files: File = File(PhotoPath)
    private val FolderPath: String = files.path


    private var filelist = files.list()


    @JvmStatic

    fun getFilelistPath(): Array<String?> {

        filelist.sort()
        var result: Array<String?> = arrayOfNulls<String>(filelist.size)
        for (i in 0 until filelist.size) {
            //  println(filelist[i])
            result!![i] = "$FolderPath/${filelist[i]}"
        }
        return result
    }


}