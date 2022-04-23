package Attachment

class NoteAttachment(
    override var type: String = "note",
    var note: Note = Note(),
) : Attachment {
    class Note(
        var id: Int = 0,
        var ownerId: Int = 0,
        var title: String = " ",
        var text: String = " ",
        var date: Int = 0,
        var comments: Int = 0,
        var readComments: Int = 0,
        var viewUrl: String = " ",
        var privacyView: Array<String> = emptyArray(),
        var privacyComment: Array<String> = emptyArray(),
        var canComment: Boolean = true,
        var textWiki: String = " "
    ) { }
}