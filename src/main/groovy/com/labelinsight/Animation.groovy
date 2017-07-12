package com.labelinsight

class Animation {

    final static L = 'L'.toCharacter()
    final static R = 'R'.toCharacter()
    final static C = 'C'.toCharacter()

    final int speed
    final String init

    Animation(int speed, String init) {
        this.speed = speed
        this.init = init
    }

    String[] animate() {
        List<String> animationList = [init]
        String newString = init
        while (Animation.stringContainsROrL(newString)) {
            newString = generateParticleRepresentation(newString)
            animationList << newString
        }

        Animation.replacePositionWithX(animationList)
    }

    private static boolean stringContainsROrL(String newString) {
        newString.contains('L') || newString.contains('R') || newString.contains('C')
    }

    private String generateParticleRepresentation(String newString) {
        Character[] charArray = new Character[numberOfLocations()]
        Arrays.fill(charArray, '.'.toCharacter())
        newString.toCharArray().toList().eachWithIndex { char particleDirection, int particlePosition ->
            if (particleDirection == L && particlePosition - speed >= 0) {
                Animation.moveParticleLeft(charArray, particlePosition - speed)
            } else if (particleDirection == R && particlePosition + speed <= numberOfLocations() - 1) {
                Animation.moveParticleRight(charArray, particlePosition + speed)
            } else if (particleDirection == C) {
                if (particlePosition - speed >= 0) {
                    Animation.moveParticleLeft(charArray, particlePosition - speed)
                }
                if (particlePosition + speed <= numberOfLocations() - 1) {
                    Animation.moveParticleRight(charArray, particlePosition + speed)
                }
            }
        }
        charArray.join()
    }

    private int numberOfLocations() {
        init.size()
    }

    private static String[] replacePositionWithX(List<String> animationList) {
        List<String> replacementList = []
        animationList.each {
            replacementList << it.replaceAll('[R|L|C]', 'X')
        }
        replacementList.toArray()
    }

    private static void moveParticleLeft(Character[] charArray, int newPosition) {
        Animation.moveParticle(charArray, newPosition, L)
    }

    private static void moveParticleRight(Character[] charArray, int newPosition) {
        Animation.moveParticle(charArray, newPosition, R)
    }

    private static void moveParticle(Character[] charArray, int newPosition, Character direction) {
        if (charArray[newPosition] != '.'.toCharacter()) {
            charArray[newPosition] = C
        } else {
            charArray[newPosition] = direction
        }
    }

}
