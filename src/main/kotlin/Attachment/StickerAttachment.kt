package Attachment

class StickerAttachment(
    override var type: String = "sticker",
    var sticker: Sticker = Sticker(),
) : Attachment {
    class Sticker(
        var productId: Int = 0,
        var stickerId: Int = 0,
        var images: Array<Image> = emptyArray(),
        var imagesWithBackground: Array<Image> = emptyArray(),
        var animationUrl: String = " ",
        var isAllowed: Boolean = true
    ) { }

    class Image(
        var url: String = " ",
        var width: Int = 1280,
        var height: Int = 720
    ) {}
}