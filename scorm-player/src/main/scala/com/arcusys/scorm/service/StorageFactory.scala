package com.arcusys.scorm.service

import com.arcusys.scorm.storage.impl.orbroker._

object StorageFactory
{
  def getPackageStorage = new PackagesStorageImpl
  def getActivitiesStorage = new ActivitiesStorageImpl
  def getOrganizationsStorage = new OrganizationsStorageImpl
  def getResourcesStorage = new ResourcesStorageImpl
}