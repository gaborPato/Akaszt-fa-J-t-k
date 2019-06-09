package controller

import controller.state.FindOutWords

object WordsVerify {
    @JvmStatic

            /*
            * @param: a megmyomott betügomb
            * @return: lista a helyes betük stringben elfoglalt helyéről.
            *
             */

    fun charVerify(buttonWord: String, fou: FindOutWords): MutableList<Int> {


        var result = arrayListOf<Int>()


        if (!fou.getWord().toLowerCase().contains(buttonWord))

            return result
        else {
            for (i in 0 until fou.getWord().length) {
                if (fou.getWord().toLowerCase()[i] == buttonWord[0])
                    result.add(i)
            }
        }
        return result;
    }


}