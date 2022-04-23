package Attachment

class PageAttachment(
    override var type: String = "page",
    var page: Page = Page(),
) : Attachment {
    class Page(
        var id: Int = 0,
        var groupId: Int = 1,
        var creatorId: Int = 1,
        var title: String = " ",
        var currentUserCanEdit: Boolean = true,
        var currentUserCanEditAccess: Boolean = true,
        var whoCanView: Int = 2,
        var whoCanEdit: Int = 0,
        var edited: Int = 0,
        var created: Int = 0,
        var editorId: Int = 0,
        var views: Int = 0,
        var parent: String = " ",
        var parent2: String = " ",
        var source: String = " ",
        var html: String = " ",
        var viewUrl: String = " "
    ) { }
}