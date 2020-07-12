package com.assignment.imagessubredditviewer

/**
 * Created by Divya Gupta.
 */
class SubRedditJsonResponse {
    var kind: String = ""
    var data: DataBeanX? = null

    class DataBeanX {
        var modhash: String = ""
        var dist = 0
        var after: String = ""
        var before: Any? = null
        var children: List<ChildrenBean>? = null

        class ChildrenBean {
            /**
             * kind : t3
             * data : {"approved_at_utc":null,"subreddit":"Images","selftext":"","author_fullname":"t2_12k259","saved":false,"mod_reason_title":null,"gilded":0,"clicked":false,"title":"Had to make this today. I feel it's better without any context.","link_flair_richtext":[{"e":"text","t":"Random"}],"subreddit_name_prefixed":"r/Images","hidden":false,"pwls":6,"link_flair_css_class":"","downs":0,"thumbnail_height":93,"top_awarded_type":null,"hide_score":false,"name":"t3_hopzcp","quarantine":false,"link_flair_text_color":"light","upvote_ratio":0.85,"author_flair_background_color":null,"subreddit_type":"public","ups":152,"total_awards_received":0,"media_embed":{},"thumbnail_width":140,"author_flair_template_id":null,"is_original_content":false,"user_reports":[],"secure_media":null,"is_reddit_media_domain":true,"is_meta":false,"category":null,"secure_media_embed":{},"link_flair_text":"Random","can_mod_post":false,"score":152,"approved_by":null,"author_premium":false,"thumbnail":"https://b.thumbs.redditmedia.com/PkQNYeh6ezWMrhD4Z1KoJtpZQbSAt738seLWzsng_4Y.jpg","edited":false,"author_flair_css_class":null,"author_flair_richtext":[],"gildings":{},"post_hint":"image","content_categories":null,"is_self":false,"mod_note":null,"created":1594420411,"link_flair_type":"richtext","wls":6,"removed_by_category":null,"banned_by":null,"author_flair_type":"text","domain":"i.redd.it","allow_live_comments":false,"selftext_html":null,"likes":null,"suggested_sort":null,"banned_at_utc":null,"url_overridden_by_dest":"https://i.redd.it/odty0f26j1a51.jpg","view_count":null,"archived":false,"no_follow":false,"is_crosspostable":false,"pinned":false,"over_18":false,"preview":{"images":[{"source":{"url":"https://preview.redd.it/odty0f26j1a51.jpg?auto=webp&amp;s=f57a1a8f4a346bc1effb3eac9c998276679ad1fa","width":1913,"height":1277},"resolutions":[{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=0b021f281c1cec0ba6123af2ea866ee274536d00","width":108,"height":72},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=2beb2df1fd27c78811b82ab1061c9f2569f3289b","width":216,"height":144},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=8327c3c5f0726f5d710faa30260e2fd77edd7877","width":320,"height":213},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=640&amp;crop=smart&amp;auto=webp&amp;s=a83d84c561b5dc6fda41059606b377d74d472092","width":640,"height":427},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=960&amp;crop=smart&amp;auto=webp&amp;s=be7ddc8607df3bb7be50fd865d77a4b8cf6ed5a9","width":960,"height":640},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=1080&amp;crop=smart&amp;auto=webp&amp;s=3240956aed1d633d0e9dd17493e2fdd92ca23b1d","width":1080,"height":720}],"variants":{},"id":"DbzGcMZIWNr6EdM_jb7NmcXVgJphSjuL3clJgEMp5C8"}],"enabled":true},"all_awardings":[],"awarders":[],"media_only":false,"link_flair_template_id":"0db4c4ce-ec7d-11e4-a81b-22000bb26836","can_gild":false,"spoiler":false,"locked":false,"author_flair_text":null,"treatment_tags":[],"visited":false,"removed_by":null,"num_reports":null,"distinguished":null,"subreddit_id":"t5_2qtjz","mod_reason_by":null,"removal_reason":null,"link_flair_background_color":"#373c3f","id":"hopzcp","is_robot_indexable":true,"report_reasons":null,"author":"Xenox_Arkor","discussion_type":null,"num_comments":15,"send_replies":true,"whitelist_status":"all_ads","contest_mode":false,"mod_reports":[],"author_patreon_flair":false,"author_flair_text_color":null,"permalink":"/r/Images/comments/hopzcp/had_to_make_this_today_i_feel_its_better_without/","parent_whitelist_status":"all_ads","stickied":false,"url":"https://i.redd.it/odty0f26j1a51.jpg","subreddit_subscribers":76395,"created_utc":1594391611,"num_crossposts":0,"media":null,"is_video":false}
             */
            var kind: String = ""
            var data: DataBean? = null

            class DataBean {
                /**
                 * approved_at_utc : null
                 * subreddit : Images
                 * selftext :
                 * author_fullname : t2_12k259
                 * saved : false
                 * mod_reason_title : null
                 * gilded : 0
                 * clicked : false
                 * title : Had to make this today. I feel it's better without any context.
                 * link_flair_richtext : [{"e":"text","t":"Random"}]
                 * subreddit_name_prefixed : r/Images
                 * hidden : false
                 * pwls : 6
                 * link_flair_css_class :
                 * downs : 0
                 * thumbnail_height : 93
                 * top_awarded_type : null
                 * hide_score : false
                 * name : t3_hopzcp
                 * quarantine : false
                 * link_flair_text_color : light
                 * upvote_ratio : 0.85
                 * author_flair_background_color : null
                 * subreddit_type : public
                 * ups : 152
                 * total_awards_received : 0
                 * media_embed : {}
                 * thumbnail_width : 140
                 * author_flair_template_id : null
                 * is_original_content : false
                 * user_reports : []
                 * secure_media : null
                 * is_reddit_media_domain : true
                 * is_meta : false
                 * category : null
                 * secure_media_embed : {}
                 * link_flair_text : Random
                 * can_mod_post : false
                 * score : 152
                 * approved_by : null
                 * author_premium : false
                 * thumbnail : https://b.thumbs.redditmedia.com/PkQNYeh6ezWMrhD4Z1KoJtpZQbSAt738seLWzsng_4Y.jpg
                 * edited : false
                 * author_flair_css_class : null
                 * author_flair_richtext : []
                 * gildings : {}
                 * post_hint : image
                 * content_categories : null
                 * is_self : false
                 * mod_note : null
                 * created : 1594420411
                 * link_flair_type : richtext
                 * wls : 6
                 * removed_by_category : null
                 * banned_by : null
                 * author_flair_type : text
                 * domain : i.redd.it
                 * allow_live_comments : false
                 * selftext_html : null
                 * likes : null
                 * suggested_sort : null
                 * banned_at_utc : null
                 * url_overridden_by_dest : https://i.redd.it/odty0f26j1a51.jpg
                 * view_count : null
                 * archived : false
                 * no_follow : false
                 * is_crosspostable : false
                 * pinned : false
                 * over_18 : false
                 * preview : {"images":[{"source":{"url":"https://preview.redd.it/odty0f26j1a51.jpg?auto=webp&amp;s=f57a1a8f4a346bc1effb3eac9c998276679ad1fa","width":1913,"height":1277},"resolutions":[{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=0b021f281c1cec0ba6123af2ea866ee274536d00","width":108,"height":72},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=2beb2df1fd27c78811b82ab1061c9f2569f3289b","width":216,"height":144},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=8327c3c5f0726f5d710faa30260e2fd77edd7877","width":320,"height":213},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=640&amp;crop=smart&amp;auto=webp&amp;s=a83d84c561b5dc6fda41059606b377d74d472092","width":640,"height":427},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=960&amp;crop=smart&amp;auto=webp&amp;s=be7ddc8607df3bb7be50fd865d77a4b8cf6ed5a9","width":960,"height":640},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=1080&amp;crop=smart&amp;auto=webp&amp;s=3240956aed1d633d0e9dd17493e2fdd92ca23b1d","width":1080,"height":720}],"variants":{},"id":"DbzGcMZIWNr6EdM_jb7NmcXVgJphSjuL3clJgEMp5C8"}],"enabled":true}
                 * all_awardings : []
                 * awarders : []
                 * media_only : false
                 * link_flair_template_id : 0db4c4ce-ec7d-11e4-a81b-22000bb26836
                 * can_gild : false
                 * spoiler : false
                 * locked : false
                 * author_flair_text : null
                 * treatment_tags : []
                 * visited : false
                 * removed_by : null
                 * num_reports : null
                 * distinguished : null
                 * subreddit_id : t5_2qtjz
                 * mod_reason_by : null
                 * removal_reason : null
                 * link_flair_background_color : #373c3f
                 * id : hopzcp
                 * is_robot_indexable : true
                 * report_reasons : null
                 * author : Xenox_Arkor
                 * discussion_type : null
                 * num_comments : 15
                 * send_replies : true
                 * whitelist_status : all_ads
                 * contest_mode : false
                 * mod_reports : []
                 * author_patreon_flair : false
                 * author_flair_text_color : null
                 * permalink : /r/Images/comments/hopzcp/had_to_make_this_today_i_feel_its_better_without/
                 * parent_whitelist_status : all_ads
                 * stickied : false
                 * url : https://i.redd.it/odty0f26j1a51.jpg
                 * subreddit_subscribers : 76395
                 * created_utc : 1594391611
                 * num_crossposts : 0
                 * media : null
                 * is_video : false
                 */
                var approved_at_utc: Any? = null
                var subreddit: String = ""
                var selftext: String = ""
                var author_fullname: String = ""
                var isSaved = false
                var mod_reason_title: Any? = null
                var gilded = 0
                var isClicked = false
                var title: String = ""
                var subreddit_name_prefixed: String = ""
                var isHidden = false
                var pwls = 0
                var link_flair_css_class: String = ""
                var downs = 0
                var thumbnail_height = 0
                var top_awarded_type: Any? = null
                var isHide_score = false
                var name: String = ""
                var isQuarantine = false
                var link_flair_text_color: String = ""
                var upvote_ratio = 0.0
                var author_flair_background_color: Any? = null
                var subreddit_type: String = ""
                var ups = 0
                var total_awards_received = 0
                var media_embed: MediaEmbedBean? = null
                var thumbnail_width = 0
                var author_flair_template_id: Any? = null
                var isIs_original_content = false
                    private set
                var secure_media: Any? = null
                var isIs_reddit_media_domain = false
                    private set
                var isIs_meta = false
                    private set
                var category: Any? = null
                var secure_media_embed: SecureMediaEmbedBean? = null
                var link_flair_text: String = ""
                var isCan_mod_post = false
                var score = 0
                var approved_by: Any? = null
                var isAuthor_premium = false
                var thumbnail: String = ""
                var isEdited = false
                var author_flair_css_class: Any? = null
                var gildings: GildingsBean? = null
                var post_hint: String = ""
                var content_categories: Any? = null
                var isIs_self = false
                    private set
                var mod_note: Any? = null
                var created = 0
                var link_flair_type: String = ""
                var wls = 0
                var removed_by_category: Any? = null
                var banned_by: Any? = null
                var author_flair_type: String = ""
                var domain: String = ""
                var isAllow_live_comments = false
                var selftext_html: Any? = null
                var likes: Any? = null
                var suggested_sort: Any? = null
                var banned_at_utc: Any? = null
                var url_overridden_by_dest: String = ""
                var view_count: Any? = null
                var isArchived = false
                var isNo_follow = false
                var isIs_crosspostable = false
                    private set
                var isPinned = false
                var isOver_18 = false
                var preview: PreviewBean? = null
                var isMedia_only = false
                var link_flair_template_id: String = ""
                var isCan_gild = false
                var isSpoiler = false
                var isLocked = false
                var author_flair_text: Any? = null
                var isVisited = false
                var removed_by: Any? = null
                var num_reports: Any? = null
                var distinguished: Any? = null
                var subreddit_id: String = ""
                var mod_reason_by: Any? = null
                var removal_reason: Any? = null
                var link_flair_background_color: String = ""
                var id: String = ""
                var isIs_robot_indexable = false
                    private set
                var report_reasons: Any? = null
                var author: String = ""
                var discussion_type: Any? = null
                var num_comments = 0
                var isSend_replies = false
                var whitelist_status: String = ""
                var isContest_mode = false
                var isAuthor_patreon_flair = false
                var author_flair_text_color: Any? = null
                var permalink: String = ""
                var parent_whitelist_status: String = ""
                var isStickied = false
                var url: String = ""
                var subreddit_subscribers = 0
                var created_utc = 0
                var num_crossposts = 0
                var media: Any? = null
                var isIs_video = false
                    private set
                var link_flair_richtext: List<LinkFlairRichtextBean>? =
                    null
                var user_reports: List<*>? = null
                var author_flair_richtext: List<*>? = null
                var all_awardings: List<*>? = null
                var awarders: List<*>? = null
                var treatment_tags: List<*>? = null
                var mod_reports: List<*>? = null

                fun setIs_original_content(is_original_content: Boolean) {
                    isIs_original_content = is_original_content
                }

                fun setIs_reddit_media_domain(is_reddit_media_domain: Boolean) {
                    isIs_reddit_media_domain = is_reddit_media_domain
                }

                fun setIs_meta(is_meta: Boolean) {
                    isIs_meta = is_meta
                }

                fun setIs_self(is_self: Boolean) {
                    isIs_self = is_self
                }

                fun setIs_crosspostable(is_crosspostable: Boolean) {
                    isIs_crosspostable = is_crosspostable
                }

                fun setIs_robot_indexable(is_robot_indexable: Boolean) {
                    isIs_robot_indexable = is_robot_indexable
                }

                fun setIs_video(is_video: Boolean) {
                    isIs_video = is_video
                }

                class MediaEmbedBean
                class SecureMediaEmbedBean
                class GildingsBean
                class PreviewBean {
                    /**
                     * images : [{"source":{"url":"https://preview.redd.it/odty0f26j1a51.jpg?auto=webp&amp;s=f57a1a8f4a346bc1effb3eac9c998276679ad1fa","width":1913,"height":1277},"resolutions":[{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=0b021f281c1cec0ba6123af2ea866ee274536d00","width":108,"height":72},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=2beb2df1fd27c78811b82ab1061c9f2569f3289b","width":216,"height":144},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=8327c3c5f0726f5d710faa30260e2fd77edd7877","width":320,"height":213},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=640&amp;crop=smart&amp;auto=webp&amp;s=a83d84c561b5dc6fda41059606b377d74d472092","width":640,"height":427},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=960&amp;crop=smart&amp;auto=webp&amp;s=be7ddc8607df3bb7be50fd865d77a4b8cf6ed5a9","width":960,"height":640},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=1080&amp;crop=smart&amp;auto=webp&amp;s=3240956aed1d633d0e9dd17493e2fdd92ca23b1d","width":1080,"height":720}],"variants":{},"id":"DbzGcMZIWNr6EdM_jb7NmcXVgJphSjuL3clJgEMp5C8"}]
                     * enabled : true
                     */
                    var isEnabled = false
                    var images: List<ImagesBean>? = null

                    class ImagesBean {
                        /**
                         * source : {"url":"https://preview.redd.it/odty0f26j1a51.jpg?auto=webp&amp;s=f57a1a8f4a346bc1effb3eac9c998276679ad1fa","width":1913,"height":1277}
                         * resolutions : [{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=0b021f281c1cec0ba6123af2ea866ee274536d00","width":108,"height":72},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=2beb2df1fd27c78811b82ab1061c9f2569f3289b","width":216,"height":144},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=8327c3c5f0726f5d710faa30260e2fd77edd7877","width":320,"height":213},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=640&amp;crop=smart&amp;auto=webp&amp;s=a83d84c561b5dc6fda41059606b377d74d472092","width":640,"height":427},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=960&amp;crop=smart&amp;auto=webp&amp;s=be7ddc8607df3bb7be50fd865d77a4b8cf6ed5a9","width":960,"height":640},{"url":"https://preview.redd.it/odty0f26j1a51.jpg?width=1080&amp;crop=smart&amp;auto=webp&amp;s=3240956aed1d633d0e9dd17493e2fdd92ca23b1d","width":1080,"height":720}]
                         * variants : {}
                         * id : DbzGcMZIWNr6EdM_jb7NmcXVgJphSjuL3clJgEMp5C8
                         */
                        var source: SourceBean? = null
                        var variants: VariantsBean? = null
                        var id: String = ""
                        var resolutions: List<ResolutionsBean>? = null

                        class SourceBean
                        class VariantsBean
                        class ResolutionsBean {
                            /**
                             * url : https://preview.redd.it/odty0f26j1a51.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=0b021f281c1cec0ba6123af2ea866ee274536d00
                             * width : 108
                             * height : 72
                             */
                            var url: String = ""
                            var width = 0
                            var height = 0

                        }
                    }
                }

                class LinkFlairRichtextBean {
                    /**
                     * e : text
                     * t : Random
                     */
                    var e: String = ""
                    var t: String = ""

                }
            }
        }
    }
}