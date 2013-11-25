package global

import play.api._
import com.stormpath.sdk.client._
import com.stormpath.sdk.ds._

import java.util.Properties
import java.io.{File,FileInputStream}

object Global extends GlobalSettings {

	// get the properties from file: appID and directoryID
	private val properties = new Properties()
    properties.load(new FileInputStream(new File(System.getProperty("user.home") + "/.stormpath/application.properties")))
    private val appID = properties.getProperty("application.id")
    private val dirID = properties.getProperty("directory.id")

	// get the stormpath credentials, create client
	private val path = System.getProperty("user.home") + "/.stormpath/apiKey.properties"
	val client = new ClientBuilder().setApiKeyFileLocation(path).build()

	private val appHref = s"https://api.stormpath.com/v1/applications/$appID"
	val app = client.getDataStore().getResource(appHref, classOf[com.stormpath.sdk.application.Application])   

	private val dirRef = s"https://api.stormpath.com/v1/directories/$dirID"	
	val directory = client.getDataStore().getResource(dirRef, classOf[com.stormpath.sdk.directory.Directory])
}
