package Attachment

class EventAttachment(
    override var type: String = "event",
    var event: Event = Event(),
) : Attachment {
    class Event(
        var id: Int = 0,
        var time: Int = 1,
        var memberStatus: Int = 2,
        var isFavorite: Boolean = true,
        var address: String = " ",
        var text: String = " ",
        var buttomText: String = " ",
        var friends: Array<Int> = emptyArray()
    ) { }
}