package com.jacobo.gradle.plugins.tasks

import org.gradle.api.file.CopySpec
import org.gradle.api.tasks.bundling.War
import org.gradle.api.internal.file.copy.CopySpecImpl

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory

import org.gradle.api.logging.Logging
import org.gradle.api.logging.Logger

/**
 * Assembles a WAR archive for the wsdl plugin, adds extra functionality to war
 *
 * @author Daniel Mijares
 */
class WsdlWarTask extends War { 

  static final Logger log = Logging.getLogger(WsdlWarTask.class)

  @Input
  String wsdlFolder

  @Input
  String schemaFolder

  @InputDirectory
  File wsdl

  @InputDirectory
  File schema

  WsdlWarTask() { 
    super()
    log.debug("Calling war constructor")

    webInf.into({ getWsdlFolder() }) { 
      from { 
	getWsdl()
      }
    }

    webInf.into({ getSchemaFolder() }) { 
      from { 
	getSchema()
      }
    }
  }
  
  
}