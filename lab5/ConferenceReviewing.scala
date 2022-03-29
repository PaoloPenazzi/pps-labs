package u05lab.ex2

import scala.collection.immutable.HashMap

enum Question:
  case RELEVANCE
  case SIGNIFICANCE
  case CONFIDENCE
  case FINAL

trait ConferenceReviewing:
  def loadReview(article: Int, map: Map[Question ,Int]): Unit

  def loadReview(article: Int, rel: Int, sig: Int, conf: Int, fin: Int): Unit

  def orderedScores(article: Int, question: Question): List[Int]

  def averageFinalScore(article: Int): Double

  def acceptedArticle(): Set[Int]

  def sortedAcceptedArticles(): List[(Int, Double)]

  def averageWeightedFinalScoreMap(): Map[Int, Double]
