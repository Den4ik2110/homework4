package Attachment

class PrettyCardsAttachment(
    override var type: String = "pretty_cards",
    var prettyCards: Array<PrettyCards> = emptyArray()
) : Attachment {
    class PrettyCards(
        var cardId: String = " ",
        var linkUrl: String = " ",
        var title: String = " ",
        var images: Array<Image> = emptyArray(),
        var buttom: Buttoms = Buttoms(),
        var price: String = " ",
        var priceOld: String = " "
    ) {}

    class Buttoms(
        var text: String = " ",
        var color: String = " "
    ) {}

    class Image(
        var url: String = " ",
        var width: Int = 1280,
        var height: Int = 720,
    ) {}
}