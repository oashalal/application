package main

import (
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/container"
	"fyne.io/fyne/v2/widget"
)

func main() {
	a := app.New()
    w := a.NewWindow("Hello")

	hello := widget.NewLabel("Hello Fyne!")
    entry := widget.NewEntry()
    entry.SetText("name")

	w.SetContent(container.NewVBox(
		hello,
		widget.NewButton("Hi!", func() {
			hello.SetText("Welcome :)")
		}),
        widget.NewLabel("Hello oashalal"),
        entry,
	)) 

    w.ShowAndRun()
}
