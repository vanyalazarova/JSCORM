/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arcusys.scorm.service.util

object PathBuilder
{
  // get real path to .class file
  val sourceLocation = getClass.getProtectionDomain.getCodeSource.getLocation.getPath
  // extract path to SCORM packages data directory
  lazy val outputRealDir = sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF")) + "/SCORMData/"
  //lazy val outputAbstractDir = sourceLocation.substring(sourceLocation.lastIndexOf("/scorm-player"), sourceLocation.lastIndexOf("/WEB-INF")) + "/SCORMData/"
  lazy val outputWebDir = {
    // parse context path
    val realDir = sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF"))
    realDir.substring(realDir.lastIndexOf("/")) + "/SCORMData/"
  }


  def buildRealPath(packageID: Int, resourceHref: String, manifestBase: String = "", resourceBase: String = ""):String =
  {
    outputRealDir + "data/" + 
     packageID.toString + "/" + 
     (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
     (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
     resourceHref
  }
  
  def buildURL(packageID: Int, resourceHref: String, manifestBase: String, resourceBase: String):String =
  {
    "/SCORMData/data/" + 
     packageID.toString + "/" + 
     (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
     (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
     resourceHref
  }
}