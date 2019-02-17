export class LibraryUiUtils {
  static libraryHeight(cardsNumber, type) {
    const extraOpponentRotation = type === 'opponent' ? 'rotateZ(180deg) ' : ''
    const halfCardsNumber = Math.floor(cardsNumber / 2)
    return {
      transform: `${extraOpponentRotation} translateZ(${halfCardsNumber}px)`,
    }
  }

  static libraryBottomThickness(cardsNumber) {
    const halfCardsNumber = Math.floor(cardsNumber / 2)
    return {
      height: `${cardsNumber}px`,
      bottom: `-${halfCardsNumber}px`,
      transform: `rotateX(-90deg)`
    }
  }

  static libraryRightThickness(cardsNumber) {
    const halfCardsNumber = Math.floor(cardsNumber / 2)
    return {
      width: `${cardsNumber}px`,
      right: `-${halfCardsNumber}px`,
      transform: `rotateY(-90deg)`
    }
  }
}