/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package uk.ac.bolton.archimate.editor.ui.factory.business;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import uk.ac.bolton.archimate.editor.diagram.editparts.business.BusinessEventEditPart;
import uk.ac.bolton.archimate.editor.ui.IArchimateImages;
import uk.ac.bolton.archimate.model.IArchimatePackage;


/**
 * Business Event UI Provider
 * 
 * @author Phillip Beauvoir
 */
public class BusinessEventUIProvider extends AbstractBusinessUIProvider {

    public EClass providerFor() {
        return IArchimatePackage.eINSTANCE.getBusinessEvent();
    }
    
    @Override
    public EditPart createEditPart() {
        return new BusinessEventEditPart();
    }

    @Override
    public String getDefaultName() {
        return Messages.BusinessEventUIProvider_0;
    }

    @Override
    public String getDefaultShortName() {
        return Messages.BusinessEventUIProvider_1;
    }

    @Override
    public Image getImage() {
        return IArchimateImages.ImageFactory.getImage(IArchimateImages.ICON_BUSINESS_EVENT_16);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_BUSINESS_EVENT_16);
    }
}
