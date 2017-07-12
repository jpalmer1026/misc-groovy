package com.labelinsight

import spock.lang.Specification
import spock.lang.Unroll

class AnimationSpec extends Specification {

    @Unroll
    void 'animate returns expected results for speed #speed and init #init'() {
        given: 'an animation object'
        Animation animation = new Animation(speed, init)

        when: 'animate is invoked with an intial speed and conditions'
        String[] result = animation.animate()

        then:
        result == expectedResult.toArray()

        where:
        speed | init         || expectedResult
        2     | '..R....'    || ['..X....',
                                 '....X..',
                                 '......X',
                                 '.......']
        3     | 'RR..LRL'    || ['XX..XXX',
                                 '.X.XX..',
                                 'X.....X',
                                 '.......']
        2     | 'LRLR.LRLR'  || ['XXXX.XXXX',
                                 'X..X.X..X',
                                 '.X.X.X.X.',
                                 '.X.....X.',
                                 '.........']
        10    | 'RLRLRLRLRL' || ['XXXXXXXXXX',
                                 '..........']
        1     | '...'        || ['...']
        1     | 'LRRL.LR.LRR.R.LRRL.'        || ['XXXX.XX.XXX.X.XXXX.',
                                                 '..XXX..X..XX.X..XX.',
                                                 '.X.XX.X.X..XX.XX.XX',
                                                 'X.X.XX...X.XXXXX..X',
                                                 '.X..XXX...X..XX.X..',
                                                 'X..X..XX.X.XX.XX.X.',
                                                 '..X....XX..XX..XX.X',
                                                 '.X.....XXXX..X..XX.',
                                                 'X.....X..XX...X..XX',
                                                 '.....X..X.XX...X..X',
                                                 '....X..X...XX...X..',
                                                 '...X..X.....XX...X.',
                                                 '..X..X.......XX...X',
                                                 '.X..X.........XX...',
                                                 'X..X...........XX..',
                                                 '..X.............XX',
                                                 '.X...............XX',
                                                 'X.................X',
                                                 '...................']
    }
}
