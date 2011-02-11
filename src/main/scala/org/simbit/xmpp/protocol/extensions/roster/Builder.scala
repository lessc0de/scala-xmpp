package org.simbit.xmpp
{
	package protocol.extensions.roster
	{
		import scala.collection._
		import scala.xml._
		
		import org.simbit.xmpp.protocol._
		import org.simbit.xmpp.protocol.message._
		import org.simbit.xmpp.protocol.extensions._
		
		import org.simbit.xmpp.protocol.Protocol._
		
		object Builder extends ExtensionBuilder[Query]
		{
			val name = Query.name
			val namespace = "jabber:iq:roster"
			
			def apply(xml:Node):Query = 
			{
				(xml \ "item").length match
				{
					case 0 => Roster(xml)
					case _ => RosterResult(xml)
				}
			}
		}
		
	}
}