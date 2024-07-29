
package org.itc.com

object mapReduce extends App{

  val lst = List(10,20, 30)
  val lst1 = lst.map(i => i*i)
  println(lst1(1))

  println(lst.reduce((i,j) => i-j))

}
