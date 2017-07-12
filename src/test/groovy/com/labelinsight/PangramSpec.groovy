package com.labelinsight

import spock.lang.Specification
import spock.lang.Unroll

class PangramSpec extends Specification {

    @Unroll
    void "getMissingLetters returns \"#expectedResults\" for input \"#inputSentence\""() {
        given: 'a pangram object initialized using an input sentence set by the test'
        Pangram pangram = new Pangram(inputSentence)

        when: 'getMissingLetters is invoked'
        String results = pangram.getMissingLetters()

        then: 'invoking getMissingLetters with a sentence containing all the letters of the alphabet returns an empty string'
        results == expectedResults

        where:
        inputSentence                                      || expectedResults
        'A quick brown fox jumps over the lazy dog'        || ''
        'A slow yellow fox crawls under the proactive dog' || 'bjkmqz'
        'Lions, and tigers, and bears, oh my!'             || 'cfjkpquvwxz'
        ''                                                 || 'abcdefghijklmnopqrstuvwxyz'
    }
}
