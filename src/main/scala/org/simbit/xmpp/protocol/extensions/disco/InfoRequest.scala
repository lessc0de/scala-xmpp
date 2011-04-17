package org.simbit.xmpp
{
	package protocol.extensions.disco
	{
		import scala.collection._
		import scala.xml._
		
		import org.simbit.xmpp.protocol._
		import org.simbit.xmpp.protocol.iq._
		import org.simbit.xmpp.protocol.extensions._
		
		import org.simbit.xmpp.protocol.Protocol._
		
		object InfoRequest 
		{
			def apply(node:Option[String]=None):InfoRequest = 
			{
				val attributes:MetaData = if (!node.isEmpty) new UnprefixedAttribute("node", Text(node.get), Null) else Null
				return apply(InfoBuilder.build(attributes))
			}
			
			def apply(xml:Node):InfoRequest = new InfoRequest(xml)
		}
		
		class InfoRequest(xml:Node) extends Query(xml)
		{
			val node:Option[String] = (this.xml \ "@node").text
			
			def result(identity:Identity, feature:Feature):InfoResult = InfoResult(this.node, List(identity), List(feature))
			
			def result(identity:Identity, features:Seq[Feature]):InfoResult = InfoResult(this.node, List(identity), features)
			
			def result(identities:Seq[Identity], features:Seq[Feature]):InfoResult = InfoResult(this.node, identities, features)
		}
		
	}
}