/*******************************************************************************
 * Copyright (c) 2010 Bolton University, UK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 *******************************************************************************/
package uk.ac.bolton.archimate.editor.propertysections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import uk.ac.bolton.archimate.model.FolderType;
import uk.ac.bolton.archimate.model.IArchimatePackage;
import uk.ac.bolton.archimate.model.IFolder;


/**
 * Property Section for a Folder
 * 
 * @author Phillip Beauvoir
 */
public class FolderSection extends AbstractArchimatePropertySection {
    
    private static final String HELP_ID = "uk.ac.bolton.archimate.help.folderSection";
    
    /*
     * Adapter to listen to changes made elsewhere (including Undo/Redo commands)
     */
    private Adapter eAdapter = new AdapterImpl() {
        @Override
        public void notifyChanged(Notification msg) {
            Object feature = msg.getFeature();
            // Folder Name event (Undo/Redo and here)
            if(feature == IArchimatePackage.Literals.NAMEABLE__NAME ) {
                refreshNameField();
                fPage.labelProviderChanged(null); // Update Main label
            }
            // Folder Documentation event (Undo/Redo and here)
            else if(feature == IArchimatePackage.Literals.DOCUMENTABLE__DOCUMENTATION) {
                refreshDocumentationField();
            }
        }
    };


    private IFolder fFolder;
    
    private PropertySectionTextControl fTextName;
    private PropertySectionTextControl fTextDocumentation;
    
    @Override
    protected void createControls(Composite parent) {
        fTextName = createNameControl(parent, "Add a name for this folder here");
        fTextDocumentation = createDocumentationControl(parent, "Add documentation relating to this folder here");
        
        // Help ID
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, HELP_ID);
    }
    
    @Override
    protected void setElement(Object element) {
        if(element instanceof IFolder) {
            fFolder = (IFolder)element;
        }
        else {
            System.err.println("Section wants to display for " + element);
        }
    }
    
    @Override
    public void refresh() {
        // Populate fields...
        refreshNameField();
        refreshDocumentationField();
    }
    
    protected void refreshNameField() {
        fTextName.getTextControl().setEnabled(fFolder != null && fFolder.getType() == FolderType.USER);
        fTextName.refresh(fFolder);
    }
    
    protected void refreshDocumentationField() {
        fTextDocumentation.refresh(fFolder);
    }

    @Override
    protected Adapter getECoreAdapter() {
        return eAdapter;
    }

    @Override
    protected EObject getEObject() {
        return fFolder;
    }
    
    @Override
    public boolean shouldUseExtraSpace() {
        return true;
    }

}
