import Attachment.Attachment
import kotlin.RuntimeException

data class Post(
    var text: String,
    var attachment: Array<Attachment> = emptyArray(),
    var copyHistory: Array<Post>? = emptyArray(),
    var postSource: PostSource? = null,
    var copyright: Copyright = Copyright(),
    var comments: Comment = Comment(),
    var reposts: Repost = Repost(),
    var donut: Donut = Donut(),
    var views: View = View(),
    var likes: Like = Like(),
    var geo: Geo? = Geo(),
    var isFavorite: Boolean = false,
    var markedAsAds: Boolean = true,
    var canDelete: Boolean = false,
    var postType: String = "post",
    var canEdit: Boolean = false,
    var canPin: Boolean = true,
    var replyOwnerId: Int = 1,
    var createdBy: Int = 333,
    var replyPostId: Int = 1,
    var friendsOnly: Int = 1,
    var postponedId: Int = 0,
    var singerId: Int = 777,
    var ownerId: Int = 111,
    var isPinned: Int = 1,
    var fromId: Int = 222,
    var date: Int = 444,
    var id: Int = 0
) {
    class Donut(
        var placeholder: Limiter = Limiter(),
        var canPublishFreeCopy: Boolean = true,
        var isDonut: Boolean = false,
        var editMode: String = "all",
        var paidDuration: Int = 10
    ) {}

    class Limiter(var bung: String = " ") {}

    class View(
        var count: Int = 0
    ) {}

    class Repost(
        var userReposted: Boolean = false,
        var count: Int = 0
    ) {}

    class Like(
        var canPublish: Boolean = true,
        var userLikes: Boolean = false,
        var canLike: Boolean = true,
        var count: Int = 0
    ) {}

    class Comment(
        var groupsCanPost: Boolean = true,
        var canClose: Boolean = false,
        var canOpen: Boolean = false,
        var canPost: Boolean = true,
        var count: Int = 0
    ) {}

    class Copyright(
        var link: String = " ",
        var name: String = " ",
        var type: String = " ",
        val id: Int = 0
    ) {}

    class PostSource(
        var type: String = " ",
        var platform: String = " ",
        var data: String = " ",
        var url: String = " "
    ) {}

    class Geo(
        var place: Place = Place(),
        var type: String = " ",
        var coordinates: String = " "
    ) {
        class Place(
            var id: Int = 0,
            var title: String = " ",
            var latitude: Int = 0,
            var longtitude: Int = 0,
            var created: Int = 0,
            var icon: String = " ",
            var checkins: Int = 0,
            var updated: Int = 0,
            var type: Int = 0,
            var country: Int = 0,
            var city: Int = 0,
            var address: String = " "
        ) {}
    }
}

data class Comment(
    var message: String,
    var commentId: Int = 0,
    var ownerId: Int = -1,
    var postId: Int = 1,
    var fromGroup: Int = 1,
    var replyToComment: Int = 1,
    var attachment: Array<Attachment> = emptyArray(),
    var stickerId: Int = 4,
    var quid: String = " "
) {}

class PostNotFoundException(message: String): RuntimeException(message)

object WallService {
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()

    fun createComment(comment: Comment) {
        for (i in posts.indices) {
            if (posts[i].id == comment.postId) {
                comment.commentId = comments.size + 1
                comments += comment
                println("Комментарий добавлен")
                return
            }
        }
        throw PostNotFoundException ("Максимальное значение id среди имеющихся постов = ${posts.size}, хотите добавить комментарий к посту с id = ${comment.postId}")
    }

    fun add(post: Post): Post {
        post.id = posts.size + 1
        posts += post
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for (oldPost in posts) {
            if (newPost.id == oldPost.id) {
                oldPost.text = newPost.component1()
                oldPost.attachment = newPost.component2()
                oldPost.copyHistory = newPost.component3()
                oldPost.postSource = newPost.component4()
                oldPost.copyright = newPost.component5()
                oldPost.comments = newPost.component6()
                oldPost.reposts = newPost.component7()
                oldPost.donut = newPost.component8()
                oldPost.views = newPost.component9()
                oldPost.likes = newPost.component10()
                oldPost.geo = newPost.component11()
                oldPost.isFavorite = newPost.component12()
                oldPost.markedAsAds = newPost.component13()
                oldPost.canDelete = newPost.component14()
                oldPost.postType = newPost.component15()
                oldPost.canEdit = newPost.component16()
                oldPost.canPin = newPost.component17()
                oldPost.replyOwnerId = newPost.component18()
                oldPost.createdBy = newPost.component19()
                oldPost.replyPostId = newPost.component20()
                oldPost.friendsOnly = newPost.component21()
                oldPost.postponedId = newPost.component22()
                oldPost.singerId = newPost.component23()
                oldPost.ownerId = newPost.component24()
                oldPost.isPinned = newPost.component25()
                oldPost.fromId = newPost.component26()
                oldPost.date = newPost.component27()
                oldPost.id = newPost.component28()
                return true
            }
        }
        return false
    }
}

fun main() {
    var postOne = Post(
        text = "aaa"
    )
    WallService.add(postOne)

    var postTwo = Post(
        text = "bbb"
    )
    WallService.add(postTwo)

    var postThree = postTwo.copy(text = "ccc")

    println(if (WallService.update(postThree)) "Пост обновлен" else "Не найден пост для обновления")

    var commentOne: Comment = Comment("First comment")

    WallService.createComment(commentOne)
}