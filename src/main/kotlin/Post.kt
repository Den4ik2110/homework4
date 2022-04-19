data class Post(
    var copyright: Copyright,
    var comments: Comment,
    var reposts: Repost,
    var text: String,
    var donut: Donut,
    var views: View,
    var likes: Like,
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
        var placeholder: Limiter,
        var canPublishFreeCopy: Boolean = true,
        var isDonut: Boolean = false,
        var editMode: String = "all",
        var paidDuration: Int = 10
    ) {

    }

    class Limiter(var bung: String = " ") {

    }

    class View(
        var count: Int = 0
    ) {

    }

    class Repost(
        var userReposted: Boolean = false,
        var count: Int = 0
    ) {

    }

    class Like(
        var canPublish: Boolean = true,
        var userLikes: Boolean = false,
        var canLike: Boolean = true,
        var count: Int = 0
    ) {

    }

    class Comment(
        var groupsCanPost: Boolean = true,
        var canClose: Boolean = false,
        var canOpen: Boolean = false,
        var canPost: Boolean = true,
        var count: Int = 0
    ) {

    }

    class Copyright(
        var link: String = " ",
        var name: String = " ",
        var type: String = " ",
        val id: Int = 0
    ) {

    }
}


object WallService {
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        post.id = posts.size + 1
        posts += post
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for (oldPost in posts) {
            if (newPost.id == oldPost.id) {
                oldPost.copyright = newPost.component1()
                oldPost.comments = newPost.component2()
                oldPost.reposts = newPost.component3()
                oldPost.text = newPost.component4()
                oldPost.donut = newPost.component5()
                oldPost.views = newPost.component6()
                oldPost.likes = newPost.component7()
                oldPost.isFavorite = newPost.component8()
                oldPost.markedAsAds = newPost.component9()
                oldPost.canDelete = newPost.component10()
                oldPost.postType = newPost.component11()
                oldPost.canEdit = newPost.component12()
                oldPost.canPin = newPost.component13()
                oldPost.replyOwnerId = newPost.component14()
                oldPost.createdBy = newPost.component15()
                oldPost.replyPostId = newPost.component16()
                oldPost.friendsOnly = newPost.component17()
                oldPost.postponedId = newPost.component18()
                oldPost.singerId = newPost.component19()
                oldPost.ownerId = newPost.component20()
                oldPost.isPinned = newPost.component21()
                oldPost.fromId = newPost.component22()
                oldPost.date = newPost.component23()
                oldPost.id = newPost.component24()
                return true
            }
        }
        return false
    }
}

fun main() {
    var postOne = Post(Post.Copyright(), Post.Comment(), Post.Repost(), text = "aaa", Post.Donut(Post.Limiter()), Post.View(), Post.Like())
    println(postOne.id)
    WallService.add(postOne)
    println(postOne.id)

    var postTwo = Post(Post.Copyright(), Post.Comment(), Post.Repost(), text = "bbb", Post.Donut(Post.Limiter()), Post.View(), Post.Like())
    WallService.add(postTwo)

    var post3 = postTwo.copy(text = "ccc")

    println(postTwo.text)
    println(if (WallService.update(post3)) "Пост обновлен" else "Не найден пост для обновления")
    println(postOne.text)
}