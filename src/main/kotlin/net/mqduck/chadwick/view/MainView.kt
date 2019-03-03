package net.mqduck.chadwick.view

import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import javafx.scene.input.KeyCode
import javafx.scene.layout.AnchorPane
import tornadofx.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class MainView : View("Chadwick") {
    override val root: AnchorPane by fxml()
    private val startTimeField: TextField by fxid()
    private val startDateField: DatePicker by fxid()

    private val timeFormat = SimpleDateFormat("hh:mm a")

    private var startTime = Date()

    init {
        startTimeField.text = timeFormat.format(Date())
        startTimeField.focusedProperty().addListener { observable, oldValue, newValue ->
            setTime()
        }
        startTimeField.setOnKeyReleased { event ->
            if (event.getCode() === KeyCode.ENTER) {
                setTime()
            }
        }

        startDateField.value = LocalDate.now()
    }

    private fun setTime() {
        try {
            startTime = timeFormat.parse(startTimeField.text)
        } catch (e: ParseException) {
        }
        startTimeField.text = timeFormat.format(startTime)
    }
}
