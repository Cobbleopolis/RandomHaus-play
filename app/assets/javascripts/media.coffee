class @Video
    constructor: (@id, @channelId, @seriesId, @name) ->

    @fromJSON: (videoObj) -> new @ videoObj.id, videoObj.channelId, videoObj.seriesId, videoObj.name
        
class @Playlist
    constructor: (@id, @channelId, @name) ->
        
    @fromJSON: (playlistObj) -> new @ playlistObj.id, playlistObj.channelId, playlistObj.name