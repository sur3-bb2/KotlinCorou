package com.rsk.introfx

import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import tornadofx.*

fun main(args: Array<String>) = launch<CoroutineApp>(args)


class CoroutineApp : App(IntroView::class) {
    override fun start(stage: Stage) {
        stage.width = 200.0
        stage.height = 400.0
        super.start(stage)
    }
}

class IntroView : View() {
    override val root = BorderPane()
    val counter = SimpleIntegerProperty()

    init {
        title = "Counter"

        with(root) {
            style {
                padding = box(20.px)
            }

            center {
                vbox(10.0) {
                    alignment = Pos.CENTER

                    label() {
                        bind(counter)
                        style { fontSize = 25.px }
                    }

                    button("Click to increment") {

                    }.setOnAction {
                        increment()
                    }
                }
            }
        }
    }

    fun increment() {
        Thread.sleep(3000)
        counter.value += 1
    }
}
