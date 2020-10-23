# twitterClone
Api's with curl :

getUserViaUsername
curl --location --request GET 'http://localhost:8080/api/v1/user/username?username=karan' 

createUser
curl --location --request POST 'http://localhost:8080/api/v1/user/username?username=karan&password=123q3e

addFollower
curl --location --request POST 'http://localhost:8080/api/v1/user/add/follower?username=karan' \
--data-raw '{
    "username" : "vegeta"
}'

getFollowerList
curl --location --request GET 'http://localhost:8080/api/v1/user/get/follower/list?username=karan'

getFollowingList
curl --location --request GET 'http://localhost:8080/api/v1/user/get/following/list?username=karan'

getPostList
curl --location --request GET 'http://localhost:8080/api/v1/user/get/post/list?username=karan'

getAccessToken
curl --location --request POST 'http://localhost:8080/api/v1/user/login/hash/code' \
--data-raw '{
    "username" : "karan",
    "password" : "123"
}'

addPost
curl --location --request POST 'http://localhost:8080/api/v1/post/add/post?username=karan' \
--data-raw '{
    "content" : "this is normal post content"
}'




How to get started : 
Create a database twitter_clone 
add approriate database location url in properties file 
