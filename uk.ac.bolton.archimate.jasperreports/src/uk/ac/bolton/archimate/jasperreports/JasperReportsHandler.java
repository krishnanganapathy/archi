/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package uk.ac.bolton.archimate.jasperreports;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;

import uk.ac.bolton.archimate.editor.actions.AbstractModelSelectionHandler;
import uk.ac.bolton.archimate.editor.ui.components.ExtendedWizardDialog;
import uk.ac.bolton.archimate.model.IArchimateModel;


/**
 * Command Action Handler for Jasper Reports
 * 
 * @author Phillip Beauvoir
 */
public class JasperReportsHandler extends AbstractModelSelectionHandler {
    
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IArchimateModel model = getActiveArchimateModel();
        if(model != null) {
            WizardDialog dialog = new ExtendedWizardDialog(workbenchWindow.getShell(),
                    new ExportJasperReportsWizard(model),
                    "ExportJasperReportsWizard"); //$NON-NLS-1$
            dialog.open();
        }

        return null;
    }
    
}
