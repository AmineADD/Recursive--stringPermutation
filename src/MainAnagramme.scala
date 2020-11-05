import java.util
import java.util.Arrays

object  MainAnagramme {
  val NOM_1="abcdefg";
  val NOM_2="elephant"
  def main(args: Array[String]) {
    usageMessage("Récursive");
    println(s"Nombre de combinaisons du '${NOM_1}' : ${trouveAnagrammesDe(NOM_1).size}");
    println(s"Nombre de combinaisons du '${NOM_2}' : ${trouveAnagrammesDe(NOM_2).size}");
   /*
    usageMessage("Utilitaire");
    println(s"Nombre de combinaisons du '${NOM_1}' : ${permutations(NOM_1.toCharArray())}");
    println(s"Nombre de combinaisons du '${NOM_2}' : ${permutations(NOM_2.toCharArray())}");
    */

  }


  def usageMessage(msg:String){
    println(s"_____________________________ ${msg} Solution___________________________")
  }

  def trouveAnagrammesDe(_mot:String):Set[String]={
    var posibilite: Set[String] = Set();
    if (_mot.length < 1) {
      posibilite += _mot;
      return posibilite;
    }
    for (i <- 0 until _mot.length) {
      val aChar: Char = _mot.charAt(i);
      val partie: String = _mot.substring(0, i) + _mot.substring(i + 1);
      val partieRecupereEtAajouter: Set[String] = trouveAnagrammesDe(partie);
      for (permutatedStr <- partieRecupereEtAajouter) {
        posibilite += (aChar + permutatedStr);
      }
    }
    return posibilite;
  }
/*
  private def rotate(size: Int, i: Int, s: Array[Char]){
    var j = size - 1
    while ( {
      j > i && s(j) <= s(i - 1)
    }) j -= 1
    swap(s, i - 1, j)
    reverse(s, i, size - 1)
  }

  private def swap(arr: Array[Char], i: Int, j: Int){
    val c = arr(i)
    arr(i) = arr(j)
    arr(j) = c
  }

  private def reverse(arr:Array[Char],i: Int ,j:Int ){
      while (i<j){
        var INDICE_I=i;
        INDICE_I=INDICE_I-1;
        var INDICE_J=j;
        INDICE_J=INDICE_J-1;
        swap(arr,INDICE_I,INDICE_J);
      }
  }

 def permutations(_mot_chars:Array[Char]): Unit ={
   val size:Int=_mot_chars.length;
   scala.util.Sorting.quickSort(_mot_chars);
   var p:Int=0;
   while(true){
     p=p+1;
     var i:Int=size-1;
     while ( {_mot_chars(i - 1) >= _mot_chars(i)}){
       if ( {i -= 1; i} == 0)
         return p
     }
     rotate(size,i,_mot_chars);
   }
 }
 */
}
