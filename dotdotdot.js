console.log('running. . .');

const fs = require('fs');
const Twit = require('twit');
const Config = require('./config');
const exec = require('child_process').exec;

let T = new Twit(Config);

tweetType01();
setInterval(tweetType01, 1000*60*60);

function tweetType01() {

    const contentCmd = 'processing-java --sketch=`pwd`/pdeGen --run';
    exec(contentCmd, pdeGenContent);

    function pdeGenContent() {
        const fileName = 'pdeGen/output.jpg';
        const params = {
            encoding: 'base64'
        }
        let b64 = fs.readFileSync(fileName, params);

        T.post('media/upload', { media_data: b64 }, uploaded);

        function uploaded(err, data, response) {
            const id = data.media_id_string;
            let tweet = {
                status: '',
                media_ids: [id]
            }
            T.post('statuses/update', tweet, tweeted);
        }

        function tweeted(err, data, response) {
            if (err) {
                console.log('there was an error w/ a Type01 Tweet');
            } else {
                console.log('Type01 Tweet Completed');
            }
        }
    }
}
