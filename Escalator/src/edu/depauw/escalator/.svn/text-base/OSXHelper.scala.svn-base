package edu.depauw.escalator

import com.apple.eawt._

object OSXHelper {
  lazy val app = new Application
  
  var quitHandler : ApplicationListener = null
  var aboutHandler : ApplicationListener = null
  var preferencesHandler : ApplicationListener = null
  var openFileHandler : ApplicationListener = null
  
  def setQuitHandler(action : => Boolean) {
    if (quitHandler != null) app.removeApplicationListener(quitHandler)
    quitHandler = new ApplicationAdapter {
      override def handleQuit(event : ApplicationEvent) {
        val handled = action
        event.setHandled(handled)
      }
    }
    app.addApplicationListener(quitHandler)
  }
  
  def setAboutHandler(action : => Unit) {
    if (aboutHandler != null) app.removeApplicationListener(aboutHandler)
    aboutHandler = new ApplicationAdapter {
      override def handleAbout(event : ApplicationEvent) {
        action
        event.setHandled(true)
      }
    }
    app.addApplicationListener(aboutHandler)
  }
  
  def setPreferencesHandler(action : => Unit) {
    if (preferencesHandler != null) app.removeApplicationListener(preferencesHandler)
    preferencesHandler = new ApplicationAdapter {
      override def handlePreferences(event : ApplicationEvent) {
        action
        event.setHandled(true)
      }
    }
    app.addApplicationListener(preferencesHandler)
  }
  
  def setOpenFileHandler(action : String => Unit) {
    if (openFileHandler != null) app.removeApplicationListener(openFileHandler)
    openFileHandler = new ApplicationAdapter {
      override def handleOpenFile(event : ApplicationEvent) {
        action(event.getFilename)
        event.setHandled(true)
      }
    }
    app.addApplicationListener(openFileHandler)
  }
}
