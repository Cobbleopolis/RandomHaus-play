player = null

window.onYouTubeIframeAPIReady = () ->
    getRandomVideo((videoId) ->
        player = new YT.Player 'player',
            height: 390
            width: 640
            videoId: videoId
        $('#vidID').text(videoId)
    )


getRandomVideo = (callback) ->
    $.ajax "/api/getRandomVideo/UCboMX_UNgaPBsUOIgasn3-Q",
        type: "GET"
        dataType: "text"
        error: (jqXHR, textStatus, errorThrown) ->
            alert(errorThrown)
            callback('')
        success: (data, textStatus, jqXHR) ->
            callback(data)
            
window.loadRandomVideo = () ->
    player.destroy()
    getRandomVideo((videoId) ->
        player = new YT.Player 'player',
            height: 390
            width: 640
            videoId: videoId
            events:
                'onReady': onPlayerReady
        $('#vidID').text(videoId)
    )
    
onPlayerReady = (event) ->
#    event.target.playVideo()