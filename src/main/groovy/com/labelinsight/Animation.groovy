package com.labelinsight

class Animation {

    final int speed
    final String init

    Animation(int speed, String init) {
        this.speed = speed
        this.init = init
    }

    String[] animate() {
        List<String> animationList = [init]
        String newString = init
        while (stringContainsROrL(newString)) {
            newString = moveParticle(newString)
            animationList << newString
        }

        replacePositionWithX(animationList)
    }

    private boolean stringContainsROrL(String newString) {
        newString.contains('L') || newString.contains('R')
    }

    private String[] replacePositionWithX(List<String> animationList) {
        List<String> replacementList = []
        animationList.each {
            replacementList << it.replaceAll('[R|L|/*]', 'X')
        }
        replacementList.toArray()
    }

    private String moveParticle(String newString) {
        Character[] charArray = new Character[numberOfLocations()]
        Arrays.fill(charArray, '.'.toCharacter())
        newString.toCharArray().toList().eachWithIndex { char ch, int index ->
            if (ch == 'L'.toCharacter() && index - speed >= 0) {
                int newPosition = index - speed
                if (charArray[newPosition] != '.'.toCharacter()) {
                    charArray[newPosition] = '*'.toCharacter()
                } else {
                    charArray[newPosition] = 'L'.toCharacter()
                }
            } else if (ch == 'R' && index + speed <= numberOfLocations() - 1) {
                charArray[index + speed] = 'R'.toCharacter()
            } else if (ch == '*'.toCharacter()) {
                if (index - speed >= 0) {
                    charArray[index - speed] = 'L'.toCharacter()
                }
                if (index + speed <= numberOfLocations() - 1) {
                    charArray[index + speed] = 'R'.toCharacter()
                }
            }
        }
        charArray.join()
    }


    private int numberOfLocations() {
        init.size()
    }


}
