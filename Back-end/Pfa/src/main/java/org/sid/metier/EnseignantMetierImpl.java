/*package org.sid.metier;

import org.sid.dao.PublicationRepository;
import org.sid.entities.Enseignant;
import org.sid.entities.Publication;

public class EnseignantMetierImpl implements IEnseignantMetier{
 PublicationRepository publicationRepository;
	public void publier(Enseignant ens, Publication pub) {
		publicationRepository.save(new Publication(pub.getDate(), pub.getContenu(), ens, pub.getMatiere()));
	}

}
*/